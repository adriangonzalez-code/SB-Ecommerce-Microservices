```toml
name = 'Update Product'
method = 'PUT'
url = 'http://localhost:8082/api/products/1'
sortWeight = 2000000
id = '4a94ddc2-a7f9-4035-a25c-07c09836695e'

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
