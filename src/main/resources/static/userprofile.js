// The base URL of your API
const API_BASE_URL = 'http://localhost:8765';

// Fetches a user from the server by their ID
function getUserById(id) {
    return fetch(`${API_BASE_URL}/users/${id}`)
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

// Get the user ID from the URL
let urlParams = new URLSearchParams(window.location.search);
let id = urlParams.get('id');

// Fetch the user from the server
getUserById(id).then(user => {
    // Use the fetched user to fill in the page
    document.getElementById('username').textContent = user.username;
   /* document.getElementById('points').textContent = user.points;*/

    // Populate the list of articles
    let userArticlesList = document.getElementById('user-articles-list');
    user.articles.forEach(article => {
        let listItem = document.createElement('li');
        listItem.textContent = article.title;
        userArticlesList.appendChild(listItem);
    });

    // Set up the settings button to link to the settings page for this user
    document.getElementById('settings-button').addEventListener('click', () => {
        window.location.href = `/settings.html?id=${user.id}`; // assuming you have a settings page that also works based on user ID
    });
}).catch(error => {
    console.error('Error:', error);
});
