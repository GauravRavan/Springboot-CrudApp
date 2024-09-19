assignment 3

app.js
#!/usr/bin/node
var http = require(&#39;http&#39;);
http.createServer(function (req, res) {
console.log(new Date().toUTCString() + &quot; - &quot; + req.url);
res.writeHead(200, {&#39;Content-Type&#39;: &#39;text/plain&#39;});
res.end(&#39;Hello, Docker.\n&#39;);
}).listen(3000);
console.log(&#39;Server running at http://0.0.0.0:3000/&#39;);


Dockerfile

FROM mhart/alpine-node:4.4

COPY app.js .

EXPOSE 3000

ENTRYPOINT ["node", "app.js"]


docker build . -t nodeassignment

docker -ps -a

docker run -d -p 3000:3000 -it nodeassignment

to check -: ip + 3000





q2

app.py

#!/usr/bin/python3

app = Flask(__name__)

@app.route("/")
def main():
    return "Welcome!"

@app.route('/hackers')
def hello():
    return 'Hey buddy, how are you?'

if __name__ == "__main__":
    app.run(host="0.0.0.0", port=8080)


Dockerfile

FROM python:3.9-alpine

RUN pip install requests

COPY app.py .

EXPOSE 8080

ENTRYPOINT ["python", "usr/src/app.py"]

docker build -t flaskassignment .

docker run -d -p 8000:8000 -it nodeassignment

to check -: ip + 8000


Q3

docker pull jenkins/jenkins:lts

docker run -d --name "Jenky" -p 8000:8080 -p 50000:50600 Jenkins/Jenkins:lts

192.168.131.88/8000
