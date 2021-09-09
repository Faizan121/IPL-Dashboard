import React, {useEffect, useState} from 'react'
import { useParams } from 'react-router';
import { MatchDetailCard } from '../components/MatchDetailCard'

export const MatchPage = () => {
       
    const [matches, setMacthes] = useState([]);
    const { teamName, year } = useParams();
    
    useEffect(
        () => {
            const fetchMatches = async () => {
                const resp = await fetch(`http://localhost:8080/team/${teamName}/matches?year=${year}`);
                const data = await resp.json();
                setMacthes(data);
            };
            fetchMatches();
        }, []);


    return (
        <div className="MatchPage">
           <h1>Match Page</h1>
            {matches.map(match => <MatchDetailCard teamName={teamName} match={match} /> )}
        </div>
    )
}
