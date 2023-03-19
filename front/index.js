import { getBooks, addBook, editBook, deleteBook, getPublishers, addPublisher, editPublisher, deletePublisher } from "./requests.js";

const qs = element => document.querySelector(element);
const ce = element => document.createElement(element);

const data = {
    books: [],
    publishers: []
};

const buildButton = (className, text, onClick) => {
    const button = document.createElement("button");
    button.classList.add(className);
    button.textContent = text;
    button.addEventListener("click", onClick);
    return button;
}

const renderBooks = async (specifiedBooks) => {
    const targetData = specifiedBooks || data.books;
    const parent = qs("#orgLivros");
    parent.textContent = "";
    
    if (data.books.length === 0) await getBooks().then(books => books.forEach(book => data.books.push(book)));

    targetData.forEach(book => {
        const div = ce("div");
        div.classList.add("livro");

        const p = ce("p");
        p.textContent = `${book.title}, ${book.releaseDate}`;

        const editButton = buildButton("editar", "✏️", () => {
            qs("#modal-livro").style.display = "inline-block";
            qs("#id-livro").textContent = book.id;
            qs("#titulo-livro > input").value = book.title;
            qs("#lancamento-livro > input").value = book.releaseDate;
        });

        const deleteButton = buildButton("deletar", "🗑️", async () => {
            try {
                await deleteBook(book.id);
            } finally {
                data.books = data.books.filter(dataBook => dataBook.id !== book.id);
                renderBooks();
            }
        });

        div.appendChild(p);
        div.appendChild(editButton);
        div.appendChild(deleteButton);
        parent.appendChild(div);
    });
}

const renderPublishers = async (specifiedPublishers) => {
    const targetData = specifiedPublishers || data.publishers;
    const parent = qs("#orgEditoras");
    parent.textContent = "";
    
    if (data.publishers.length === 0) await getPublishers().then(publishers => publishers.forEach(publisher => data.publishers.push(publisher)));

    targetData.forEach(publisher => {
        const div = ce("div");
        div.classList.add("editora");

        const p = ce("p");
        p.textContent = `${publisher.name}, ${publisher.origin}`;

        const editButton = buildButton("editar", "✏️", () => {
            qs("#modal-editora").style.display = "inline-block";
            qs("#id-editora").textContent = publisher.id;
            qs("#nome-editora > input").value = publisher.name;
            qs("#origem-editora > input").value = publisher.origin;
        });

        const deleteButton = buildButton("deletar", "🗑️", async () => {
            try {
                await deletePublisher(publisher.id);
            } finally {
                data.publishers = data.publishers.filter(dataPublisher => dataPublisher.id !== publisher.id);
                renderPublishers();
            }
        });

        div.appendChild(p);
        div.appendChild(editButton);
        div.appendChild(deleteButton);
        parent.appendChild(div);
    });
}

qs("#buscar-livros").addEventListener("change", () => {
    const searchValue = qs("#buscar-livros").value;
    renderBooks(data.books.filter(book => book.title.toLowerCase().includes(searchValue.toLowerCase())));
});

qs("#bntAddLiv").addEventListener("click", () => {
    qs("#modal-livro").style.display = "flex";
    qs("#id-livro").textContent = "";
    qs("#titulo-livro > input").value = "";
    qs("#lancamento-livro > input").value = "";
});

qs("#salvar-livro").addEventListener("click", async () => {
    const id = qs("#id-livro").textContent;
    const body = {
        title: qs("#titulo-livro > input").value,
        releaseDate: qs("#lancamento-livro > input").value
    };
    
    const response = !id ? await addBook(body) : await editBook(id, body);
    data.books = data.books.filter(book => book.id != id);
    data.books.push(response);
    renderBooks();

    qs("#modal-livro").style.display = "none";
});

qs("#buscar-editoras").addEventListener("change", () => {
    const searchValue = qs("#buscar-editoras").value;
    renderPublishers(data.publishers.filter(publisher => publisher.name.toLowerCase().includes(searchValue.toLowerCase())));
});

qs("#bntAddEdit").addEventListener("click", () => {
    qs("#modal-editora").style.display = "flex";
    qs("#id-editora").textContent = "";
    qs("#nome-editora > input").value = "";
    qs("#origem-editora > input").value = "";
});

qs("#salvar-editora").addEventListener("click", async () => {
    const id = qs("#id-editora").textContent;
    const body = {
        name: qs("#nome-editora > input").value,
        origin: qs("#origem-editora > input").value
    };

    const response = !id ? await addPublisher(body) : await editPublisher(id, body);
    data.publishers = data.publishers.filter(publisher => publisher.id != id);
    data.publishers.push(response);
    renderPublishers();

    qs("#modal-editora").style.display = "none";
});

qs(".fundo-modal").addEventListener("click", () => qs(".modal").style.display = "none");

renderBooks();
renderPublishers();
