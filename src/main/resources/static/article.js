// The base URL of your API
const API_BASE_URL = 'http://localhost:8765';  // Change this to match your actual API base URL

// Fetches an article from the server by its ID
function getArticleById(id) {
    return fetch(`${API_BASE_URL}/articles/${id}`)
        .then(response => {
            if (!response.ok) {
                throw new Error(`HTTP error! status: ${response.status}`);
            }
            return response.json();
        })
        .catch(error => {
            console.error('Error:', error);
        });
}
// Get the article ID from the URL
let urlParams = new URLSearchParams(window.location.search);
let id = urlParams.get('id');

// Fetch the article from the server
getArticleById(id).then(article => {
    // Use the fetched article to fill in the page
    document.getElementById('article-title').textContent = article.title;
    document.getElementById('article-author').textContent = article.author;
    document.getElementById('article-content').textContent = article.content;
    document.getElementById('article-creation-date').textContent = article.date_of_creation;
}).catch(error => {
    console.error('Error:', error);
});
