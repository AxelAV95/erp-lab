

function App() {

  return (
    <>
      <div className="bg-gray-100 min-h-screen flex flex-col items-center justify-center">
        <h1 className="text-3xl font-bold">ERP Frontend</h1>
        <p className="mt-4">Este proyecto es un sistema ERP desarrollado con un enfoque en la modularidad y la escalabilidad.</p>
        <p className="mt-2">Prueba la conexion proxy Nginx al backend <a href="/api/health" className="text-blue-500">aqui</a></p>
        <p className="mt-2">Si funciona deberias ver un mensaje JSON del backend</p>
      </div>
    </>
  )
}

export default App
