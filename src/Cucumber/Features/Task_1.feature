Feature: Add new address

  Scenario Outline: User can log in and add new address

    Given open browser on <site>
    When user logged in with <login> & <password>
    And click addresses tile
    And click +create new address
    And fill out and save form with correct values: <Alias>, <Address>, <City>, <Zip Code>, <Country>, <Phone>
    # Then data is saved in address book
   # When click delete button
    #Then address is removed

    Examples:
      | site                                  | login            | password                   | Alias  | Address       | City  | Zip Code | Phone       |
      | https://mystore-testlab.coderslab.pl/ | aceofp@gmail.com | fest_oryginalne_haslo_1111 | Kermit | Sesame Street | Bytom | 49-100   | 500-501-666 |