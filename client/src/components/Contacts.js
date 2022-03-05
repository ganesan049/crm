import React, { Component } from 'react'
import AddContacts from './AddContacts';
import SingleContact from './SingleContact';

export default class Contacts extends Component{
    constructor(props){
        super(props);
        this.state = {
            contacts: []
        }
    }

    componentDidMount() { 
        fetch("http://localhost:8080/api/contacts")
        .then(res => res.json())
        .then(data => {
            console.log(data);
            this.setState({contacts:data});
        })
     }

    render(){
        return (
            <div className="">
                <div className="row">
                    <AddContacts/>    
                </div>
                <div className="row">
                    {this.state.contacts.map((contact) => 
                        <SingleContact key={contact.id}
                        contact={contact}
                        />
                    )}    
                </div>
            </div>
        )
    }
}