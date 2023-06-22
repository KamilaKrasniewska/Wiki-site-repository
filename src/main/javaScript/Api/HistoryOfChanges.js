
const API_BASE_URL = 'ttp://localhost:8765';

// Function to get a history by id
function getHistoryById(historyId) {
    return fetch(`${API_BASE_URL}/histories/${historyId}`)
        .then(response => response.json())
        .catch(error => console.error('Error:', error));
}

// Function to get all histories
function getAllHistories() {
    return fetch(`${API_BASE_URL}/histories`)
        .then(response => response.json())
        .catch(error => console.error('Error:', error));
}

// Function to create new history
function createHistory(history) {
    return fetch(`${API_BASE_URL}/histories`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(history),
    })
        .then(response => response.json())
        .catch(error => console.error('Error:', error));
}

// Function to update a history
function updateHistory(historyId, history) {
    return fetch(`${API_BASE_URL}/histories/${historyId}`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(history),
    })
        .then(response => response.json())
        .catch(error => console.error('Error:', error));
}

// Function to delete a history
function deleteHistory(historyId) {
    return fetch(`${API_BASE_URL}/histories/${historyId}`, {
        method: 'DELETE',
    })
        .catch(error => console.error('Error:', error));
}
