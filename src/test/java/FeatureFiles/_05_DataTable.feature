Feature: Datatable Functionality

  Background:
    Given Navigate to basqar
    When Enter username and password and click login button
    Then User should login successfuly

  Scenario: Create Country
    And Click on the element in the left Nav
      | setupOne   |
      | parameters |
      | countries  |

    And Click on the element in the Dialog
      | addButton |

    And User sending the keys in Dialog content
      | nameInput | ismetCoun21 |
      | codeInput | 121233      |

    And Click on the element in the Dialog
      | saveButton |

    And Success message should be displayed

    And User delete item from Dialog
      | ismetCoun21 |

    And Success message should be displayed
  @Regression
  Scenario: Create a Nationality
    And Click on the element in the left Nav
      | setupOne      |
      | parameters    |
      | nationalities |

    And Click on the element in the Dialog
      | addButton |

    And User sending the keys in Dialog content
      | nameInput | ismetNat21 |

    And Click on the element in the Dialog
      | saveButton |

    And Success message should be displayed

    And User delete item from Dialog
      | ismetNat21 |

    And Success message should be displayed

  Scenario: Create a Fee, delete Fee

    And Click on the element in the left Nav
      | setupOne   |
      | parameters |
      | fees       |

    And Click on the element in the Dialog
      | addButton |

    And User sending the keys in Dialog content
      | nameInput       | ismetFee1 |
      | codeInput       | i123      |
      | integrationCode | 1233      |
      | priorityCode    | 422       |

    And Click on the element in the Dialog
      | saveButton |

    And Success message should be displayed

    And User delete item from Dialog
      | ismetFee1 |

    And Success message should be displayed




    #    Senaryo Outline da verilen değerler için tüm senaryo her satır kadar tekrar çalıştırılıyordu.
    #    DataTable da ise, sadece ilgili step için toplu veri gönderme imkanı oluşuyor.
    #    TODO: Kaymakçı tablo yuklenmesini

