# Poll
A restful server to make voting polls.

Integrated with MongoDB.

# API

## Create a poll
```http request
POST /api
```
The body of the request would need to look something like this
```json
{
  "question": "Does pineapple belong on pizza?",
  "answers": [
    {"label":  "yes"},
    {"label": "no"}
  ]
}
```
This will return a `pollId` (integer)

## Getting a poll
```http request
GET /api/{id}
```

## Voting
```http request
POST /api/vote
```
The body of the request would need to look something like this
```json
{
  "pollId": 0,
  "answerId": 1
}
```
The `answerId` in the index of the answer choice in the poll.