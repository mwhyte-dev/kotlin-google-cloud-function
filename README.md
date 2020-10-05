# kotlin-google-cloud-function

##### Running the function locally. 
```
./gradlew runFunction -PrunFunction.target=com.codenerve.function.App -PrunFunction.port=8080
```

##### Deploying to GCloud (basic)
```
gcloud config set functions/region europe-west1
```

```
./gradlew buildFunction

gcloud functions deploy tweet-function \
--entry-point=com.codenerve.tweet.App \
--source=build/deploy --runtime=java11 --trigger-http \
--allow-unauthenticated --set-env-vars OK=nice
```
*N.B. gcp functions need fat jars so there was gradle work to be done here. 

```
gcloud functions describe tweet-function
```
