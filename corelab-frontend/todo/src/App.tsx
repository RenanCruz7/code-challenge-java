import './App.css'
import Card from './components/Card/Card'
import CreateTask from './components/CreateTask/CreateTask'
import Header from './components/Header/Header'

function App() {

  return (
    <>
      <Header />
      <CreateTask></CreateTask>
      <Card></Card>
    </>
  )
}

export default App
