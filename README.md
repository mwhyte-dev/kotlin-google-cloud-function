# kotlin-google-cloud-function

Full blog post here: [mwhyte.dev/Creating-Google-Cloud-Functions-With-Kotlin](https://www.mwhyte.dev/Creating-Google-Cloud-Functions-With-Kotlin-10240732311180088c10d2007899dd2b)

##### Running the function locally. 
###### Basic
```
./gradlew runFunction 
```

###### With args
```
./gradlew runFunction -PrunFunction.target=dev.mwhyte.function.App -PrunFunction.port=8080
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
--entry-point=dev.mwhyte.function.App \
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
