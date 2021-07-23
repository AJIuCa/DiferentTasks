SELECT 
    s.title, s.time_start, s.time_end, people_traffic, money
FROM
    session_stat AS st
        JOIN
    session AS s ON st.session_id = s.id
ORDER BY s.time_start; 