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

CREATE TABLE Exhibition(
    exhibition_id CHAR(3) PRIMARY KEY,
    theme VARCHAR(255),
    gallery_id CHAR(3),
    FOREIGN KEY (gallery_id) REFERENCES Gallery(gallery_id)
);

CREATE TABLE Artist_Style(
    artist_id CHAR(3),
    style_id CHAR(3),
    PRIMARY KEY (artist_id, style_id),
    FOREIGN KEY (artist_id) REFERENCES Artist(artist_id),
    FOREIGN KEY (style_id) REFERENCES Style(style_id)
);

-- Populating Gallery Table
INSERT INTO Gallery (gallery_id, gallery_name, gallery_location, gallery_city, gallery_postcode)
VALUES 
('G01', 'Tate Britain', 'Millbank', 'London', 'SW1P 4RG'),
('G02', 'Tate Modern', 'Bankside', 'London', 'SE1 9TG'),
('G03', 'Tate Liverpool', 'Albert Dock', 'Liverpool', 'L3 4BB');

-- Populating Painting Table
INSERT INTO Painting (painting_id, painting_title, painting_height, painting_width, painting_medium, artist_id)
VALUES 
('P01', 'Opening of Waterloo Bridge', 1308, 2180, 'Oil on canvas', 'A01'),
('P02', 'Flatford Mill', 1016, 1270, 'Oil on canvas', 'A01'),
('P03', 'Autumnal Cannibalism', 651, 651, 'Oil on canvas', 'A02'),
('P04', 'Girl in a Chemise', 727, 600, 'Oil on canvas', 'A03'),
('P05', 'The Three Dancers', 2153, 1422, 'Oil on canvas', 'A03'),
('P06', 'Head of a Woman', 345, 265, 'Oil on canvas', 'A03'),
('P07', 'Weeping Woman', 608, 500, 'Oil on canvas', 'A03'),
('P08', 'Circus Artist and Child', 168, 105, 'Ink, watercolour', 'A02'),
('P09', 'Haymakers', 895, 1353, 'Oil on wood', 'A04'),
('P10', 'The Bay of Baiae', 1545, 2375, 'Oil on canvas', 'A05');

-- Populating Artist Table
INSERT INTO Artist (artist_id, artist_name, artist_nationality, birth_year, death_year)
VALUES 
('A01', 'John Constable', 'English', 1776, 1837),
('A02', 'Salvador Dali', 'Spanish', 1904, 1989),
('A03', 'Pablo Picasso', 'Spanish', 1881, 1973),
('A04', 'George Stubbs', 'English', 1724, 1806),
('A05', 'Joseph Turner', 'English', 1775, 1851);

-- Populating Style Table
INSERT INTO Style (style_id, style_description, style_name)
VALUES 
('S01', 'Romantic, as opposed to classical, art of the late 18th and early 19th century.', 'Romanticism'),
('S02', 'Amalgamated viewpoints of natural forms into a multifaceted surface of geometrical planes.', 'Cubism'),
('S03', 'Founded on principles of irrationality, incongruity and irreverence.', 'Dada'),
('S04', 'Juxtaposition of incongruous images including unconscious and dream elements.', 'Surrealism');

-- Populating Exhibition Table
INSERT INTO Exhibition (exhibition_id, theme, gallery_id)
VALUES 
('E01', 'Impressionist Masters', 'G01'),
('E02', 'Cubism and Modern Art', 'G02'),
('E03', 'Surrealist Revolution', 'G03');

-- Populating Artist_Style Table
INSERT INTO Artist_Style (artist_id, style_id)
VALUES 
('A01', 'S01'),
('A02', 'S02'),
('A02', 'S03'),
('A03', 'S03'),
('A03', 'S04'),
('A04', 'S01'),
('A05', 'S01');

-- Query 1: List names of English painters and years they died, ordered by death_year
SELECT artist_name, death_year
FROM Artist
WHERE artist_nationality = 'English'
ORDER BY death_year;

-- Query 2: List names of artists with work displayed in London (unique names only)
SELECT DISTINCT Artist.artist_name
FROM Artist
JOIN Painting ON Artist.artist_id = Painting.artist_id
JOIN Exhibition ON Painting.painting_id = Exhibition.exhibition_id
JOIN Gallery ON Exhibition.gallery_id = Gallery.gallery_id
WHERE Gallery.gallery_city = 'London';

-- Query 3: List names of artists who paint in geometrical style with painting count
SELECT Artist.artist_name, COUNT(Painting.painting_id) AS geometricalPaintingArtist
FROM Artist
JOIN Painting ON Artist.artist_id = Painting.artist_id
JOIN Artist_Style ON Artist.artist_id = Artist_Style.artist_id
JOIN Style ON Artist_Style.style_id = Style.style_id
WHERE Style.style_description LIKE '%geometrical%'
GROUP BY Artist.artist_name;
