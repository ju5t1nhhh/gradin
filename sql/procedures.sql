
DELIMITER //

# SensitiveWord
CREATE PROCEDURE saveSensitiveWord(IN p_section INT, IN p_word VARCHAR(10),IN p_replace VARCHAR(10))
BEGIN
IF EXISTS(SELECT `sw_replace` FROM `sensitive_word` WHERE `sw_section`=p_section AND `sw_word`=p_word ) THEN
UPDATE `sensitive_word` SET `sw_section`=p_section, `sw_replace`=p_replace WHERE `sw_word`=p_word;
ELSE
INSERT INTO `sensitive_word` VALUES(p_section,p_word,p_replace);
END IF;
SELECT ROW_COUNT() 'rows';
END;
//




DELIMITER ;