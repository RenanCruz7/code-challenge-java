import { useState } from 'react';
import './CreateTask.scss';

export default function CreateTask() {
    const [isFavorite, setIsFavorite] = useState(false);

    const toggleFavorite = () => {
        setIsFavorite(!isFavorite);
    };

    return (
        <div className="new-task-container">
            <div className="box">
                <div className="title">
                    <input
                        type="text"
                        className="input"
                        placeholder="Título"
                    />
                    <button className={`favorite ${isFavorite ? 'favorite' : ''}`} onClick={toggleFavorite}>
                        {isFavorite ? '⭐' : '☆'}
                    </button>
                </div>
                <div className="task-description">
                    <textarea
                        className="description-text"
                        placeholder="Descrição"
                    />
                </div>
            </div>
        </div>
    );
}