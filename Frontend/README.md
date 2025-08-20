# SkyCast (Local Weather Frontend)

A beautiful, minimal frontend that consumes your local API at `http://localhost:9090/weather/forecast`.

## Run

- Option A: Open `index.html` directly in your browser. If your API enforces CORS, this may require serving files over HTTP (see Option B).
- Option B: Serve the folder and open on `http://localhost:xxxx`:

```bash
npx serve -s .
```

Then use the search bar to enter a city and select the number of days.

## Notes

- The UI expects a response in the shape:
```json
{
  "weatherResponse": {
    "city": "Vasai",
    "region": "Maharashtra",
    "country": "India",
    "condition": "Light rain",
    "temperature": "26.1"
  },
  "dayTemp": [
    { "date": "2025-08-19", "minTemp": 25.5, "avgTemp": 26.1, "maxTemp": 26.5 }
  ]
}
```
- If you see a network error, ensure:
  - Your API is running on `localhost:9090`
  - It sends `Access-Control-Allow-Origin: *` (or your frontend origin) 