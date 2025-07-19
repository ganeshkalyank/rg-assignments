const express = require('express')
const morgan = require('morgan')
const bodyParser = require('body-parser')
const routes = require('./routes')

const app = express()
const PORT = 3000

app.use(morgan('combined'))
app.use(bodyParser.json())

routes(app)

app.listen(PORT, () => {
    console.log(`Server is running on http://localhost:${PORT}`)
})

