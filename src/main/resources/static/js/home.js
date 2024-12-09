async function fetchDestinations() {
    try {
        const response = await fetch('/api/destinations');
        if (!response.ok) {
            throw new Error('Failed to fetch destinations');
        }

        const destinations = await response.json();
        const gridContainer = document.getElementById('destinationGrid');
        gridContainer.innerHTML = ''; // Clear existing content

        destinations.forEach(destination => {
            const card = document.createElement('div');
            card.classList.add('destination-card');

            const image = document.createElement('img');
            image.classList.add('destination-image');
            // Use placeholder if no cover photo is available
            const imageUrl = destination.coverPhoto
                ? `data:image/jpeg;base64,${destination.coverPhoto}`
                : 'https://via.placeholder.com/300x200?text=No+Image';
            image.src = imageUrl;
            card.appendChild(image);

            const content = document.createElement('div');
            content.classList.add('destination-content');

            const title = document.createElement('h3');
            title.classList.add('destination-title');
            title.innerText = destination.name;
            content.appendChild(title);

            const location = document.createElement('p');
            location.classList.add('destination-location');
            location.innerText = `Location: ${destination.location}`;
            content.appendChild(location);

            const category = document.createElement('p');
            category.classList.add('destination-category');
            category.innerText = `Category: ${destination.category}`;
            content.appendChild(category);

            const description = document.createElement('p');
            description.classList.add('destination-description');
            description.innerText = destination.description || 'No description available.';
            content.appendChild(description);

            const rating = document.createElement('p');
            rating.classList.add('destination-rating');
            rating.innerText = destination.rating
                ? `Rating: ⭐ ${destination.rating.toFixed(1)}`
                : 'Rating: No reviews yet';
            content.appendChild(rating);

            card.appendChild(content);
            gridContainer.appendChild(card);
        });
    } catch (error) {
        console.error(error.message);
        alert('Failed to load destinations. Please try again later.');
    }
}

// Fetch destinations on page load
fetchDestinations();
