import { useState } from 'react';
import './Card.scss';

export default function Card() {
    const [isFavorite, setIsFavorite] = useState(false);
    const [title, setTitle] = useState('Título');
    const [description, setDescription] = useState('Descrição');

    const toggleFavorite = () => {
        setIsFavorite(!isFavorite);
    };

    return (
        <div className="card">
            <div className="card-header">
                <input
                    type="text"
                    className="card-title"
                    value={title}
                    onChange={(e) => setTitle(e.target.value)}
                />
                <button className={`favorite-button ${isFavorite ? 'favorite' : ''}`} onClick={toggleFavorite}>
                    {isFavorite ? '⭐' : '☆'}
                </button>
            </div>
            <hr className="divider" />
            <textarea
                className="card-description"
                value={description}
                onChange={(e) => setDescription(e.target.value)}
            />
        </div>
    );
}