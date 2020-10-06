# kotlin-google-cloud-function

##### Running the function locally. 
###### Basic
```
./gradlew runFunction 
```

###### With args
```
./gradlew runFunction -PrunFunction.target=com.codenerve.function.App -PrunFunction.port=8080
```


##### Deploying to GCloud (basic)
###### Set region
```
gcloud config set functions/region europe-west1
```

###### build function
```
./gradlew buildFunction
```

###### deploy function
```
gcloud functions deploy my-test-function \
--entry-point=com.codenerve.function.App \
--source=build/deploy --runtime=java11 --trigger-http \
--allow-unauthenticated
```

```
gcloud functions describe my-test-function
```

###### trigger function
```
curl https://<your-region>-<you-project-name>.cloudfunctions.net/my-test-function
```