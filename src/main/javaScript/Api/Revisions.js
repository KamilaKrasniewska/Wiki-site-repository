
const API_BASE_URL = 'http://localhost:8765';

// Function to get a revision by id
function getRevisionById(revisionId) {
    return fetch(`${API_BASE_URL}/revisions/${revisionId}`)
        .then(response => response.json())
        .catch(error => console.error('Error:', error));
}

// Function to get all revisions
function getAllRevisions() {
    return fetch(`${API_BASE_URL}/revisions`)
        .then(response => response.json())
        .catch(error => console.error('Error:', error));
}

// Function to create new revision
function createRevision(revision) {
    return fetch(`${API_BASE_URL}/revisions`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(revision),
    })
        .then(response => response.json())
        .catch(error => console.error('Error:', error));
}

// Function to update a revision
function updateRevision(revisionId, revision) {
    return fetch(`${API_BASE_URL}/revisions/${revisionId}`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(revision),
    })
        .then(response => response.json())
        .catch(error => console.error('Error:', error));
}

// Function to delete a revision
function deleteRevision(revisionId) {
    return fetch(`${API_BASE_URL}/revisions/${revisionId}`, {
        method: 'DELETE',
    })
        .catch(error => console.error('Error:', error));
}
