@Search
Feature: Searching for books
As a user I want to be able to search for available books so I know what I can
loan.

Scenario: Getting to the search page
Given the user is on the start page.
When the user navigates to the book search.
Then they can see the search form.

Scenario: User searches for a book that doesn't exist
Given the user is on the search page.
When the user searches for a "<search term>" in one of the "<search fields>".
Then it will display the message "No books found"
Examples:
| search term |  search fields |
| A Game of Throws | Title |
| Gorge R.R. Martin | Author |
| 1111111111111 | ISBN |

Scenario: User searches for a book that does exist
Given the user is on the search page.
When the user searches for a "<search term>" in one of the "<search fields>".
Then the results in the corresponding "<search fields>" columns will match the "<search term>".
Examples:
| search fields | search term |
| Title | A Game of Thrones |
| Author | George R.R. Martin |
| ISBN | 9780553103540 |