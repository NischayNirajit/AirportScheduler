# AirportScheduler
Aiprort Scheduler MMT

### API to fetch Data
**API Endpoint:**
`http://localhost:8080/getFlights?src=<src>&dest=<dest>`

- `<src>` → Source airport code (e.g., `DEL`)
- `<dest>` → Destination airport code (e.g., `BLR`)


### Changes in Application.properties
In application.properties:
  app.data.pathname=`<your path to CSV>`
