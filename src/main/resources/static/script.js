// The base URL of your API
const API_BASE_URL = 'http://localhost:8765';

document.addEventListener('DOMContentLoaded', (event) => {

    // Fetches all articles from the server
    function getArticles() {
        return fetch(`${API_BASE_URL}/articles`)
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

    // Display the articles
    getArticles().then(articles => {
        let articleList = document.getElementById('article-list');
        articles.forEach(article => {
            let listItem = document.createElement('li');
            let link = document.createElement('a');
            link.textContent = article.title;
            link.href = `article.html?id=${article.id}`;
            listItem.appendChild(link);
            articleList.appendChild(listItem);
        });
    });

    // Search function
    function searchArticles() {
        let searchQuery = document.getElementById('search-box').value.toLowerCase();
        let articleItems = Array.from(document.getElementById('article-list').children);

        articleItems.forEach(item => {
            let title = item.firstChild.textContent;
            if (title.toLowerCase().indexOf(searchQuery) > -1) {
                item.style.display = "";
            } else {
                item.style.display = "none";
            }
        });
    }
// Check if a user is logged in when the page loads
    document.addEventListener('DOMContentLoaded', (event) => {
        if (sessionStorage.getItem('loggedInUser')) {
            document.getElementById('user-profile-icon').href = `/userprofile.html?id=${sessionStorage.getItem('loggedInUser')}`;
        } else {
            // If no user is logged in, redirect to sign-in page when icon is clicked
            document.getElementById('user-profile-icon').href = "/signin.html";
        }
    });
    // Add event listener to the search button
    document.getElementById('search-button').addEventListener('click', searchArticles);
});
