```toml
name = 'Update Product'
method = 'PUT'
url = 'http://localhost:8080/api/products/1'
sortWeight = 2000000
id = '419a5c15-6b30-4962-a9e5-4045f127d19d'

[body]
type = 'JSON'
raw = '''
{
  "name": "New Laptop",
  "description": "Alienware m15 R7 Gaming Laptop",
  "price": "1500.00",
  "stockQuantity": "50",
  "category": "Electronics",
  "imageUrl": "https://example.com/laptop.jpg",
}'''
```
