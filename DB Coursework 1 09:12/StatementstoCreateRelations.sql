--SQL Statements that Create the Database
CREATE TABLE Gallery(
    gallery_id CHAR(3) PRIMARY KEY,
    gallery_name VARCHAR(255) UNIQUE,
    gallery_location VARCHAR(255),
    gallery_city VARCHAR(255),
    gallery_postcode VARCHAR(10)
);

CREATE TABLE Painting(
    painting_id CHAR(3) PRIMARY KEY,
    painting_title VARCHAR(255),
    painting_height INT,
    painting_width INT,
    painting_medium VARCHAR(255),
    artist_id CHAR(3),
    FOREIGN KEY (artist_id) REFERENCES Artist(artist_id)
);

CREATE TABLE Artist(
    artist_id CHAR(3) PRIMARY KEY,
    artist_name VARCHAR(255),
    artist_nationality VARCHAR(255),
    birth_year INT,
    death_year INT
);

CREATE TABLE Style(
    style_id CHAR(3) PRIMARY KEY,   
    style_description TEXT, 
    style_name VARCHAR(255)
);

CREATE TABLE Exhibition (
    exhibition_id CHAR(3) PRIMARY KEY,
    theme VARCHAR(255),
    gallery_id CHAR(3),
    FOREIGN KEY (gallery_id) REFERENCES Gallery(gallery_id)
);

CREATE TABLE Artist_Style (
    Artist_id CHAR(3),
    Style_id CHAR(3),
    PRIMARY KEY (Artist_id, Style_id),
    FOREIGN KEY (Artist_id) REFERENCES Artist(Artist_id),
    FOREIGN KEY (Style_id) REFERENCES Style(Style_id)


);

--SQL Statements that Populate the Database

-- Statements for Gallery table
INSERT INTO Gallery (Gallery_id, gallery_name, gallery_location, gallery_city, gallery_postcode)
VALUES ("G01", "Tate Britain", "Millbank", "London", "SW1P 4RG");
INSERT INTO Gallery (Gallery_id, gallery_name, gallery_location, gallery_city, gallery_postcode)
VALUES ("G02", "Tate Modern", "Bankside", "London", "SE1 9TG");
INSERT INTO Gallery (Gallery_id, gallery_name, gallery_location, gallery_city, gallery_postcode)
VALUES ("G03", "Tate Liverpool", "Albert Dock", "Liverpool", "L3 4BB");

-- Statements for Painting table
INSERT INTO Painting (Painting_id, Title, Height, Width, Medium, Artist_id)
VALUES ("P01", "Opening of Waterloo Bridge", 1308, 2180, "Oil on canvas", "A01");
INSERT INTO Painting (Painting_id, Title, Height, Width, Medium, Artist_id)
VALUES ("P02", "Flatford Mill", 1016, 1270, "Oil on canvas", "A01");
INSERT INTO Painting (Painting_id, Title, Height, Width, Medium, Artist_id)
VALUES ("P03", "Autumnal Cannibalism", 651, 651, "Oil on canvas", "A02");
INSERT INTO Painting (Painting_id, Title, Height, Width, Medium, Artist_id)
VALUES ("P04", "Girl in a Chemise", 727, 600, "Oil on canvas", "A03");
INSERT INTO Painting (Painting_id, Title, Height, Width, Medium, Artist_id)
VALUES ("P05", "The Three Dancers", 2153, 1422, "Oil on canvas", "A03");
INSERT INTO Painting (Painting_id, Title, Height, Width, Medium, Artist_id)
VALUES ("P06", "Head of a Woman", 345, 265, "Oil on canvas", "A03");
INSERT INTO Painting (Painting_id, Title, Height, Width, Medium, Artist_id)
VALUES ("P07", "Weeping Woman", 608, 500, "Oil on canvas", "A03");
INSERT INTO Painting (Painting_id, Title, Height, Width, Medium, Artist_id)
VALUES ("P08", "Circus Artist and Child", 168, 105, "Ink,watercolour", "A02");
INSERT INTO Painting (Painting_id, Title, Height, Width, Medium, Artist_id)
VALUES ("P09", "Haymakers", 895, 1353, "Oil on wood", "A04");
INSERT INTO Painting (Painting_id, Title, Height, Width, Medium, Artist_id)
VALUES ("P10", "The Bay of Baiae", 1454, 2375, "Oil on canvas", "A05");

-- Statements for Artist table
INSERT INTO Artist (artist_id, artist_name, artist_nationality, birth_year, death_year)
VALUES ("A01", "John Constable", "English", 1776, 1837);
INSERT INTO Artist (artist_id, artist_name, artist_nationality, birth_year, death_year)
VALUES ("A02", "Salvador Dali", "Spanish", 1904, 1989);
INSERT INTO Artist (artist_id, artist_name, artist_nationality, birth_year, death_year)
VALUES ("A03", "Pablo Picasso", "Spanish", 1881, 1973);
INSERT INTO Artist (artist_id, artist_name, artist_nationality, birth_year, death_year)
VALUES ("A04", "George Stubbs", "English", 1724, 1806);
INSERT INTO Artist (artist_id, artist_name, artist_nationality, birth_year, death_year)
VALUES ("A05", "Joseph Turner", "English", 1775, 1851);

-- Statements for Style table
INSERT INTO Style (Style_id, description, name)
VALUES ("S01", "Romantic, as opposed to classical, art of the late 18th and early 19th century.", "Romanticism");
INSERT INTO Style (Style_id, description, name) 
VALUES ("S02", "Amalgamated viewpoints of natural forms into a multifaceted surface of geometrical planes.", "Cubism");
INSERT INTO Style (Style_id, description, name) 
VALUES ("S03", "Founded on principles of irrationality, incongruity and irreverence.", "Dada");
INSERT INTO Style (Style_id, description, name) 
VALUES ("S04", "Juxtaposition of incongruous images including unconscious and dream elements.", "Surrealism");

-- Statements for Exhibition table
INSERT INTO Exhibition (Exhibition_id, theme, Gallery_id)
VALUES ("E01", "Impressionist Masters", "G01");
INSERT INTO Exhibition (Exhibition_id, theme, Gallery_id) 
VALUES ("E02", "Cubism and Modern Art", "G02");
INSERT INTO Exhibition (Exhibition_id, theme, Gallery_id) 
VALUES ("E03", "Surrealist Revolution", "G03");

-- Statements for Artist_Style table
INSERT INTO Artist_Style (Artist_id, Style_id)
VALUES ("A01", "S01");  
INSERT INTO Artist_Style (Artist_id, Style_id) 
VALUES ("A02", "S02");  
INSERT INTO Artist_Style (Artist_id, Style_id) 
VALUES ("A03", "S02");  
INSERT INTO Artist_Style (Artist_id, Style_id) 
VALUES ("A03", "S03");  
INSERT INTO Artist_Style (Artist_id, Style_id) 
VALUES ("A03", "S04");  
INSERT INTO Artist_Style (Artist_id, Style_id) 
VALUES ("A04", "S01");  
INSERT INTO Artist_Style (Artist_id, Style_id) 
VALUES ("A05", "S01");  



--SQL statements that Query the database

--Get all paintings and their details made by a specific artist 
SELECT painting_title, painting_height, painting_width, painting_medium
FROM Painting
WHERE Artist_id = 'A01';

--List all the exhibitions and the themes of the exhibition in a specific gallery
SELECT theme
FROM Exhibition
WHERE gallery_id = 'G01';



--SQL Queries 

--1 List the names of english painters and the years that they died
--the ordering should not depend on the order you entered data 
SELECT artist_name, death_year
FROM Artist
WHERE artist_nationality = "English"
ORDER BY death_year;