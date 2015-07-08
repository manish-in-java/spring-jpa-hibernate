INSERT INTO card(type) SELECT 'ability' FROM DUAL WHERE NOT EXISTS (SELECT 1 FROM card WHERE type='ability');
INSERT INTO card(type) SELECT 'hero' FROM DUAL WHERE NOT EXISTS (SELECT 1 FROM card WHERE type='hero');
INSERT INTO card(type) SELECT 'leader' FROM DUAL WHERE NOT EXISTS (SELECT 1 FROM card WHERE type='leader');
INSERT INTO card(type) SELECT 'unit' FROM DUAL WHERE NOT EXISTS (SELECT 1 FROM card WHERE type='unit');

INSERT INTO player(handle) SELECT 'jack' FROM DUAL WHERE NOT EXISTS (SELECT 1 FROM player WHERE handle='jack');
INSERT INTO player(handle) SELECT 'james' FROM DUAL WHERE NOT EXISTS (SELECT 1 FROM player WHERE handle='james');
INSERT INTO player(handle) SELECT 'jean' FROM DUAL WHERE NOT EXISTS (SELECT 1 FROM player WHERE handle='jean');
INSERT INTO player(handle) SELECT 'john' FROM DUAL WHERE NOT EXISTS (SELECT 1 FROM player WHERE handle='john');
INSERT INTO player(handle) SELECT 'joyce' FROM DUAL WHERE NOT EXISTS (SELECT 1 FROM player WHERE handle='joyce');

INSERT INTO card_instance(type, player_id, card_id) SELECT 'hero', p.id, c.id FROM player p, card c WHERE p.handle='jack' AND c.type='hero' AND NOT EXISTS (SELECT 1 FROM card_instance WHERE player_id=(SELECT id FROM player WHERE handle='jack') AND card_id=(SELECT id FROM card WHERE type='hero'));
INSERT INTO card_instance(type, player_id, card_id) SELECT 'leader', p.id, c.id FROM player p, card c WHERE p.handle='jack' AND c.type='leader' AND NOT EXISTS (SELECT 1 FROM card_instance WHERE player_id=(SELECT id FROM player WHERE handle='jack') AND card_id=(SELECT id FROM card WHERE type='leader'));
INSERT INTO card_instance(type, player_id, card_id) SELECT 'unit', p.id, c.id FROM player p, card c WHERE p.handle='jack' AND c.type='unit' AND NOT EXISTS (SELECT 1 FROM card_instance WHERE player_id=(SELECT id FROM player WHERE handle='jack') AND card_id=(SELECT id FROM card WHERE type='unit'));
INSERT INTO card_instance(type, player_id, card_id) SELECT 'ability', p.id, c.id FROM player p, card c WHERE p.handle='james' AND c.type='ability' AND NOT EXISTS (SELECT 1 FROM card_instance WHERE player_id=(SELECT id FROM player WHERE handle='james') AND card_id=(SELECT id FROM card WHERE type='ability'));
INSERT INTO card_instance(type, player_id, card_id) SELECT 'leader', p.id, c.id FROM player p, card c WHERE p.handle='james' AND c.type='leader' AND NOT EXISTS (SELECT 1 FROM card_instance WHERE player_id=(SELECT id FROM player WHERE handle='james') AND card_id=(SELECT id FROM card WHERE type='leader'));
INSERT INTO card_instance(type, player_id, card_id) SELECT 'leader', p.id, c.id FROM player p, card c WHERE p.handle='jean' AND c.type='leader' AND NOT EXISTS (SELECT 1 FROM card_instance WHERE player_id=(SELECT id FROM player WHERE handle='jean') AND card_id=(SELECT id FROM card WHERE type='leader'));
INSERT INTO card_instance(type, player_id, card_id) SELECT 'leader', p.id, c.id FROM player p, card c WHERE p.handle='john' AND c.type='leader' AND NOT EXISTS (SELECT 1 FROM card_instance WHERE player_id=(SELECT id FROM player WHERE handle='john') AND card_id=(SELECT id FROM card WHERE type='leader'));
