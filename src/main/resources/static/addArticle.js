// addArticle.js

// The base URL of your API
const API_BASE_URL = 'http://localhost:8765';  // Change this to match your actual API base URL

// Select the form element
const form = document.getElementById('new-article-form'); // make sure to select the correct form id

// Handle the form submission event
form.addEventListener('submit', event => {
    // Prevent the form from being submitted the default way
    event.preventDefault();

    // Create a new JavaScript object that represents the new article
    const newArticle = {
        title: document.getElementById('title').value,
        content: document.getElementById('content').value,
        shortDescription: document.getElementById('shortDescription').value,
    };

    // Send a POST request to the server with the new article data
    fetch(`${API_BASE_URL}/articles/createArticle`, {  // make sure this endpoint matches your backend endpoint
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(newArticle),
    })
        .then(response => {
            if (!response.ok) {
                throw new Error(`HTTP error! status: ${response.status}`);
            }
            return response.json();
        })
        .then(article => {
            console.log('Article created:', article);
            // Redirect to the article page
            window.location.href = `article.html?id=${article.id}`;
        })
        .catch(error => {
            console.error('Error:', error);
        });
});
