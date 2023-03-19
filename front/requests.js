const baseUrl = "http://localhost:8080/";

const buildRequestObject = ({method, body}) => {
    return {
        method: method,
        headers: {"Content-Type": "application/json"},
        body: body
    };
}

const request = async (path, object) => {
    const apiResponse = await fetch(`${apiUrl}${path}`, object).then(response => response.json());

    if (apiResponse.error) throw new Error(apiResponse.error);

    return apiResponse;
};

const getBooks = async () => request(`${baseUrl}books`, buildRequestObject({method: "GET"}));
const addBook = async (body) => request(`${baseUrl}books`, buildRequestObject({method: "POST", body}));
const editBook = async (id, body) => request(`${baseUrl}books/${id}`, buildRequestObject({method: "PUT", body}));
const deleteBook = async (id) => request(`${baseUrl}books/${id}`, buildRequestObject({method: "DELETE"}));

const getPublishers = async () => request(`${baseUrl}publishers`, buildRequestObject({method: "GET"}));
const addPublisher = async (body) => request(`${baseUrl}publishers`, buildRequestObject({method: "POST", body}));
const editPublisher = async (id, body) => request(`${baseUrl}publishers/${id}`, buildRequestObject({method: "PUT", body}));
const deletePublisher = async (id) => request(`${baseUrl}publishers/${id}`, buildRequestObject({method: "DELETE"}));

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
