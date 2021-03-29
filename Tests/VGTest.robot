*** Settings ***
Documentation                                      This is to test ofthe Infotiv car rental test website.
...                                                the login, changing date , booking, and checking booking
...                                                 logging out.
Library                                            SeleniumLibrary
Test Setup                                         Begin Web Test
Test Teardown                                      End Web Test

*** Variables ***
${BROWSER}                                          chrome
${URL}                                              http://rental19.infotiv.net/webpage/html/gui/index.php
${EMAIL}                                            testuser@tester.com
${PASSWORD}                                         abcd123
${LOGINCHECKPASS}                                   //*[@id="welcomePhrase"]
${HOMEPAGECONFIRMATION}                             When do you want to make your trip?
${MYPAGEBUTTON}                                     id=mypage
${CARDNO}                                           1234123456785678
${CARDNAME}                                         MANISH
${CARDCVV}                                          777
${BOOKDATEFROM}                                     04-04
${BOOKDATETO}                                       04-06
${CONTINUEBUTTON}                                   id=continue
${LOGGEDOUT}                                        //*[@id="login"]
${LOGGEDOUTCONFIRMATION}                            //*[@id="questionText"]


*** Keywords ***
Begin Web Test
    Open browser                                    about:blank         ${BROWSER}
    #set selenium speed                              .5
Go To Web Page
    Load Page
    Validate Login
    Verify Page Loaded
Load Page
    Go to                                            ${URL}
Validate Login
    Login
Verify Page Loaded
    Element should be visible                       ${LOGINCHECKPASS}
    Page should contain                             ${HOMEPAGECONFIRMATION}
Login
    Input Text                                      id=email        ${EMAIL}
    Input Password                                  id=password     ${PASSWORD}
    click Button                                    id=login
Check Mypage
    click Button                                    ${MYPAGEBUTTON}
Change Date
    Input Text                                      id=start    ${BOOKDATEFROM}
    Input Text                                      id=end      ${BOOKDATETO}
    click Button                                    ${CONTINUEBUTTON}
Select car
    click Button                                    id=bookQ7pass5

Confirm Booking
    Input Text                                      id=cardNum      ${CARDNO}
    Input text                                      id=fullName     ${CARDNAME}
    Input Text                                      id=cvc          ${CARDCVV}
    click Button                                    id=confirm
    click Button                                    id=mypage
Verify Logout Success Message
    click Button                                    id=logout
    Wait Until Element Is Visible                   ${LOGGEDOUT}
    Element Should Be Visible                       ${LOGGEDOUT}
End Web Test
    Close All Browsers




*** Test Case ***
User can login and book car
    [Documentation]                                   This is some basic info about the test
    [Tags]                                             VGtestone
    Given Begin Web Test
    And Go To Web Page
    And Change Date
    When Select car
    Then Confirm Booking
    And Verify Logout Success Message
    End Web Test
