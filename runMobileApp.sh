#!/bin/bash

#Setting Environment Variables
VERSION='1.0-SNAPSHOT'
APPNAME='simple-mobile-app'
java8="/usr/bin/java"

    if [[ "$#" -ne 1 ]]; then
      printf "Not enough argument to run this application \n"
      printf "# To Get List of All Contacts Type 1 \n "
      printf "# To Add a Contact Type 2 \n"
      printf "# To Change a existing contact Type 3 \n"
      printf "# To Delete a contact Type 4 \n"
      printf "# To Find a contact Type 5 \n"
      printf "# To Quit Type 6 \n"
      printf "# To Print Instructions Type 7  \n"
    fi

    printf "Running Mobile App \n"

    $java8 -cp $HOME/${APPNAME}/${APPNAME}-${VERSION}.jar mobile.customers.data.mobileProject