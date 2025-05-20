```toml
name = 'Create Product'
method = 'POST'
url = 'http://localhost:8080/api/products'
sortWeight = 1000000
id = 'f68721af-387e-4b1e-a6e0-b793b3413c86'

[body]
type = 'JSON'
raw = '''
{
  "name": "Laptop",
  "description": "Alienware m15 R6",
  "price": "1500.32",
  "stockQuantity": "10",
  "category": "Electronics",
  "imageUrl": "https://example.com/laptop.jpg",
}'''
```
