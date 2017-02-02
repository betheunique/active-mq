# Active-MQ
ActiveMQ Implementation (Event Based Notification). Using Spring without xml.

## Configuration
- Spring 4, Jersey 2
- Spring Annotation based configuration
- No xml require.

## Functionality
- Its a REST API.
- Either use as event based notification or schedule based message.

## Package & Deploy
- Start ActiveMQ on your local.
- mvn clean package
- Whole project will be packaged as war, deploy in your favourite container (Tomcat, jetty, JBoss, etc).

## Testing
- hit http://{url}/active/test
- Message will be enqueued deque on (ActiveMQ browser console).

## Future scope
- I will integrate it with my SoftBot (Slack Bot) for reminder, schedule suggestion, etc.

## Query or Suggestion
- reach out to me at abhisheksavitarai at gmail dot com.
