# visualization-tool-server

![build badge](https://github.com/bach-tran-batch-1006/visualization-tool-server/actions/workflows/sonar.yml/badge.svg)

## Project Description
The Curricula Visualization Tool is used, at a high-level, to provide a color-coded visualization for Revature Sales Representatives to showcase the various skills a certain curriculum (i.e. a batch) has learned through the course of their Revature Training Program. Each visualization is representative of various curricula and the skills they are familiar with. Each skill belongs to a category. Obviously, keeping track of which technologies each curriculum has been trained on can be a daunting task - that is why we have provided the ability to dynamically add, remove, and edit different skills, categories, and curricula to fit the needs suited at any point in time.

## Technology Used
- Java 1.8
- Spring Boot
- Spring Data
- Logback / SLF4J
- JUnit 5
- Mockito
- H2 Database
- Hibernate
- JaCoCo
- Maven

## Data Hierarchy
| Name | Description |
| --- | --- |
| Visualization | Container for everything |
| Curriculum | Describes the various skills relevant to a training program |
| Skill | A skill / technology relevant to one or more curricula |
| Category | Categorizes many skills into unique groups |

# Backend Endpoints
## Visualizations
- `POST /visualization` : Creates a new visualization
- `GET /visualization` : Gets a list of all visualizations
- `GET /visualization/:id` : Get a specific visualization
- `PUT /visualization/:id` : Update a specific visualization
- `DELETE /visualization/:id` Delete a specific visualization

#### Related Fields
- `title` : Title of the visualization

## Curricula
- `POST /curriculum` : Creates a new curriculum
- `GET /curriculum` : Gets a list of all curricula
- `GET /curriculum/:id` : Get a specific curriculum
- `PUT /curriculum/:id` : Update a specific curriculum
- `DELETE /curriculum/:id` Delete a specific curriculum

#### Related Fields
- `name` : Name of the curriculum

## Skills
- `POST /skill` : Creates a new skill
- `GET /allSkills` : Gets a list of all skills
- `GET /skill/:id` : Get a specific skill
- `PUT /skill/:id` : Update a specific skill
- `DELETE /skill/:id` Delete a specific skill

#### Related Fields
- `name` : Name of the skill
- `category` : Category Reference Object
    - `categoryId`
    - `categoryName`
    - `categoryDescription`

## Categories
- `POST /category` : Creates a new category
- `GET /category` : Gets a list of all categories
- `PUT /category/:id` : Update a specific category
- `DELETE /category/:id` Delete a specific category

#### Related Fields
- `categoryName` : Name of the category
- `categoryDescription` : Description for the category