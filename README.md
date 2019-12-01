# Android-Clean-Architecture-MVVMI-Kotlin
Sample Android Project built using MVVMI

This app consist of three screens:
1-) Login Screen:
Username and password should be verified from service A.
2-) Listing Screen:
Get customer list from service B and list them on that screen (it should include
Profile Photo, name, surname.)
3-) Detail Screen:
Show all details about user that selected at previous screen (address, phone
number, birthday). Address and phone number fields are updateable by
the user and saved locally.

Technologies used:
1- Kotlin
2- MVVM
3- Clean Architecutre 
4- Live Data
5- Mockito
6- UniversalImageLoader
7- Dagger 2
8- Coroutines

References:
1- Clean Architecture Book (Robert Marting)
2- Clean Code Book (Robert Martin)
3- MVVMI for Android - https://medium.com/@thereallukesimpson/clean-architecture-with-mvvmi-architecture-components-rxjava-8c5093337b43

This project consist of two modules:
1- Profile (Manage Login flow)
2- Customer (Include all customers flow)

Each Component follow the following architecture:
UI(Fragment/Activity) => ViewModel => UseCase => Repository

Code Coverage
https://app.codacy.com/manual/oudaykhaled/Android-Clean-Architecture-MVVMI-Kotlin/dashboard
