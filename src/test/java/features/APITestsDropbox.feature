Feature: WebAPI testing

  Background: User has already signed up on the Dropbox.com

  Scenario: Testing upload file operation
    Given User place file "data.txt" to root directory of the app
    When User upload file to app storage using API
    Then API response with file "data.txt" metadata

  Scenario: Testing get file metadata operation
    Given User has uploaded file "data.txt" to the app
    When User get file metadata using API
    Then API response with file "data.txt" metadata

  Scenario: Testing delete file operation
    Given User has file "data.txt" in app storage
    When User delete file from app storage using API
    Then API response with deleted file "data.txt" metadata