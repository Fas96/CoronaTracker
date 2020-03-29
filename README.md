# CoronaTracker

Android App using [COVID-19 Coronavirus API](https://collectapi.com/tr/api/corona/covid-19-koronavirus-istatistik-api)

## Description

a simple app that contains some basic functionality to follow Coronavirus statistics and news about Turkey.

## Tech Stack
- Dagger 2 - Used to provide dependency injection
- Retrofit 2 - OkHttp3 - request/response API
- Glide - for image loading.
- LiveData with Coroutines and Flow - Work In Progress.
- Data Binding - bind UI components in layouts to data sources

## Overview of app arch.
- follow the rules from Architecture guidelines recommended by Google.
- keep Fragments only responsible for UI related code 
- ViewModel provides data required by the UI class
- Repository layer provides data to ViewModel classes. (single source of truth)

## Remarks:

Don't forget to update [COVID-19 Coronavirus API](https://collectapi.com/tr/api/corona/covid-19-koronavirus-istatistik-api) token to yours

## TODO for near future
- [ ] improve Application UI.
- [ ] update and fix [FetchDashboardUseCase](https://github.com/muratcanbur/CoronaTracker/blob/master/app/src/main/java/co/icanteach/app/coronatracker/domain/dashboard/FetchDashboardUseCase.kt)
- [ ] add related unit tests.
- [ ] add related UI tests.
