```toml
name = 'Add To Cart'
method = 'POST'
url = 'http://localhost:8080/api/cart'
sortWeight = 1000000
id = '53114e39-a4f2-41d2-b6b0-f0bf043162c0'

[[headers]]
key = 'X-User-ID'
value = '1'

[body]
type = 'JSON'
raw = '''
{
  "productId": "1",
    "quantity": 2,
}'''
```
