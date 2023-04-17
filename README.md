## Longest Common Substring Project
Developed by Sam Andaloro
## Requirements
- Java 17
- IDE (Intellij preferred)
- Python 3.10 (optional - only used for functional tests)
## Setup
1. Download a zip file of this repository


<img width="1042" alt="github zip" src="https://user-images.githubusercontent.com/112776220/232510728-59218254-8617-4030-8364-c54422bd9aa6.png">


3. Open your IDE -> Open

<img width="802" alt="Intellij Open" src="https://user-images.githubusercontent.com/112776220/232508247-718b6d43-6620-4e0d-a38b-8e8e8b60e070.png">


3. Select the downloaded directory

<img width="489" alt="Select project" src="https://user-images.githubusercontent.com/112776220/232508375-5280307c-db80-4b32-9fe9-b2b81a00b1e6.png">


4. Open the file /src/main/java/com.comcastsam.springbootlcs/SpringbootLcsApplication and run the program

<img width="1289" alt="SpringbootLcsApplication" src="https://user-images.githubusercontent.com/112776220/232508436-926a1b3d-0f38-49f3-a6a1-0ce815742e17.png">


## Usage Options
Once the server is successfully started, the API can be tested directly with a tool such as Postman
making a POST request in the following format:

{
"setOfStrings": [
{"value": "stringA"},
{"value": "stringB"},
{"value": "stringC"}
]
}

<img width="854" alt="Postman Test" src="https://user-images.githubusercontent.com/112776220/232508497-6b78fded-6a50-40ad-9f88-f18c3e4780e8.png">


Alternatively, we can also naviagte to localhost:8080 in a browser to test the API through a webpage

<img width="1426" alt="LCS webpage" src="https://user-images.githubusercontent.com/112776220/232508615-70d90e95-b84f-4040-b56c-2fc58db55734.png">


## Testing
Unit tests can be run from src/test/java/com.comcastsam.springbootlcs/

<img width="1285" alt="JUnit Tests" src="https://user-images.githubusercontent.com/112776220/232508664-4192877c-c06c-4436-91ee-2f61571fc32a.png">


Functional tests can be performed by downloading the [python-lcs-scripts](https://github.com/samandaloro/lcs-python-scripts) project and navigating to the tests folder

<img width="1383" alt="python scripts" src="https://user-images.githubusercontent.com/112776220/232508728-e2b19d44-8913-448f-b537-a13bc380957d.png">
