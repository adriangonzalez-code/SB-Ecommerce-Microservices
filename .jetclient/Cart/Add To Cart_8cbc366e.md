```toml
name = 'Add To Cart'
method = 'POST'
url = 'http://localhost:8080/api/cart'
sortWeight = 1000000
id = '8cbc366e-2bc7-469a-be96-0bb9ff30e58c'

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
