import { ReactComponent as GithubIcon } from 'assets/img/github.svg';
import './styles.css'

function Navbar(){
    return(
      <header>
        <nav className='container'>
          <div className='dsmovies-nav-content'>
            <h1>DsMovies</h1>
            <a href='https://github.com/willianvolpato/dsmovies'>
              <div className='dsmovies-nav-contact-container'>
                <GithubIcon />
                <p className='dsmovies-nav-contact-link'>/willianvolpato/dsmovies</p>
              </div>
            </a>
          </div>
        </nav>
      </header>
    )
}

export default Navbar;
