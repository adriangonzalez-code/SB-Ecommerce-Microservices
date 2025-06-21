```toml
name = 'Create Product'
method = 'POST'
url = 'http://localhost:8082/api/products'
sortWeight = 1000000
id = '68263a45-0b42-40b6-808e-37d000229ed3'

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
