/*

const API_BASE_URL = 'ttp://localhost:8765';

// Function to get a complaint by id
function getComplaintById(complaintId) {
    return fetch(`${API_BASE_URL}/complaints/${complaintId}`)
        .then(response => response.json())
        .catch(error => console.error('Error:', error));
}

// Function to get all complaints
function getAllComplaints() {
    return fetch(`${API_BASE_URL}/complaints`)
        .then(response => response.json())
        .catch(error => console.error('Error:', error));
}

// Function to create a new complaint
function createComplaint(complaint) {
    return fetch(`${API_BASE_URL}/complaints`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(complaint),
    })
        .then(response => response.json())
        .catch(error => console.error('Error:', error));
}

// Function to update a complaint
function updateComplaint(complaintId, complaint) {
    return fetch(`${API_BASE_URL}/complaints/${complaintId}`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(complaint),
    })
        .then(response => response.json())
        .catch(error => console.error('Error:', error));
}

// Function to delete a complaint
function deleteComplaint(complaintId) {
    return fetch(`${API_BASE_URL}/complaints/${complaintId}`, {
        method: 'DELETE',
    })
        .catch(error => console.error('Error:', error));
}
*/
