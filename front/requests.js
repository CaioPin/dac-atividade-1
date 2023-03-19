const baseUrl = "http://localhost:8080/";

const buildRequestObject = ({method, body}) => {
    return {
        method: method,
        headers: {"Content-Type": "application/json"},
        body: body ? JSON.stringify(body) : null
    };
}

const request = async (path, object) => {
    const apiResponse = await fetch(`${baseUrl}${path}`, object).then(response => response.json());

    return apiResponse;
};

const getBooks = async () => request(`books`, buildRequestObject({method: "GET"}));
const addBook = async (body) => request(`books`, buildRequestObject({method: "POST", body}));
const editBook = async (id, body) => request(`books/${id}`, buildRequestObject({method: "PUT", body}));
const deleteBook = async (id) => request(`books/${id}`, buildRequestObject({method: "DELETE"}));

const getPublishers = async () => request(`publishers`, buildRequestObject({method: "GET"}));
const addPublisher = async (body) => request(`publishers`, buildRequestObject({method: "POST", body}));
const editPublisher = async (id, body) => request(`publishers/${id}`, buildRequestObject({method: "PUT", body}));
const deletePublisher = async (id) => request(`publishers/${id}`, buildRequestObject({method: "DELETE"}));

export {
    getBooks,
    addBook,
    editBook,
    deleteBook,
    getPublishers,
    addPublisher,
    editPublisher,
    deletePublisher
};
