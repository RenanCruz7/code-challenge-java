import logo from '../../assets/logo.svg';
import './Header.scss';

export default function Header() {
    return (
        <header className="headerContainer">
            <div className="logoContainer">
                <img src={logo} alt="CoreNotes" />
                <span className="title">Core Notes</span>
            </div>

            <div className="search input-group">
                <input
                    type="text"
                    className="search-input"
                    placeholder="Pesquisar notas"
                />
                <span className="search-icon input-group-text">
                    <i className="bi bi-search"></i>
                </span>
            </div>
        </header>
    );
}