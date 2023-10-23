Feature: Login souceDemo

  @Functional @Positive
Scenario: Success Login
Given Login page was showed
When Input correct username
And Input correct password
And Click button Login
Then User redirect to beranda page

  @Functional @Negative
Scenario: Unsuccessfully Login username salah
Given Login page was showed
When Input wrong username
And Input correct password
And Click button Login
Then User get an error message

  @Functional @Negative
Scenario: Unsuccessfully Login password salah
Given Login page was showed
When Input correct username
And Input wrong password
And Click button Login
Then User get an error message

  @Functional @Negative
Scenario: Unsuccessfully Login username dan password tidak diinput
Given Login page was showed
And Click button Login
Then User get an error message input tidak ada