
const API_BASE_URL = 'http://localhost:87655';

// Function to get statistics by id
function getStatisticsById(statisticsId) {
    return fetch(`${API_BASE_URL}/statistics/${statisticsId}`)
        .then(response => response.json())
        .catch(error => console.error('Error:', error));
}

// Function to get all statistics
function getAllStatistics() {
    return fetch(`${API_BASE_URL}/statistics/all`)
        .then(response => response.json())
        .catch(error => console.error('Error:', error));
}

// Function to create new statistics
function createStatistics(statistics) {
    return fetch(`${API_BASE_URL}/statistics/create`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(statistics),
    })
        .then(response => response.json())
        .catch(error => console.error('Error:', error));
}

// Function to update statistics
function updateStatistics(statisticsId, statistics) {
    return fetch(`${API_BASE_URL}/statistics/${statisticsId}`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(statistics),
    })
        .then(response => response.json())
        .catch(error => console.error('Error:', error));
}

// Function to delete statistics
function deleteStatistics(statisticsId) {
    return fetch(`${API_BASE_URL}/statistics/${statisticsId}`, {
        method: 'DELETE',
    })
        .catch(error => console.error('Error:', error));
}
