# kotlin-template-gcloud-function

This is a kotlin template is based on [mwhyte-dev/kotlin-google-cloud-function](https://github.com/mwhyte-dev/kotlin-google-cloud-function) repository.

You can find the author's article [here](https://mwhyte.dev/creating-google-cloud-functions-with-kotlin-c9fd552d6b20).

##### Running the function locally. 
###### Basic
```
./gradlew runFunction 
```

###### With args
```
./gradlew runFunction -PrunFunction.target=dev.marcocattaneo.function.HttpSampleApp -PrunFunction.port=8080
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
--entry-point=dev.marcocattaneo.function.HttpSampleApp \
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

###### remove function from gcp 
```
gcloud functions delete my-test-function
```
