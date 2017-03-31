import { Component, OnInit } from '@angular/core';

/// <reference path="../../typings/globals/jquery/index.d.ts/>

import * as service from '../socket.service';
import '/socket.io/socket.io.js';

@Component({
  selector: 'app-chat',
  moduleId: module.id,
  templateUrl: './chat.component.html',
  styleUrls: ['./chat.component.css']
})
export class ChatComponent {

  reference: any;
    resFlag = false;
    newUser = false;
    exitedUser = false;
    newUserName: string = null;
    exitedUserName: string = null;
    sentMessageUsername: string = null;
    response: string;
    clientsNameList: number[];
    message: string;
    msgCount= 0;

    constructor() {
        let reference = this;
        let temp;
        service.socket.on('broadcastToAll_chatMessage', function(resObj) {            
            reference.msgCount++;
            if (reference.sentMessageUsername !== resObj.name) {
                resObj.name = resObj.name + ': ';
                temp = $('#messages').length;
                console.log('ul length : ', temp);
                console.log(reference.msgCount);
                $('#messages').append($('<li data-index=' + reference.msgCount + '>'));
                $('li[data-index=' + reference.msgCount + ']').append($('<div class=\'left-msg\' data-index=' + reference.msgCount + '>'));
                $('div[data-index=' + reference.msgCount + ']').append($('<span class=\'name\'>').text(resObj.name));
                $('div[data-index=' + reference.msgCount + ']').append($('<span class=\'msg\'>').text(resObj.msg));
                $('#messages').append($('<br>'));

            }
            else if (reference.sentMessageUsername === resObj.name) {
                $('#messages').append($('<li data-index=' + reference.msgCount + '>'));
                $('li[data-index=' + reference.msgCount + ']').append($('<div class=\'right-msg\' data-index=' + reference.msgCount + '>'));
                $('div[data-index=' + reference.msgCount + ']').append($('<span class=\'msg\'>').text(resObj.msg));
                 $('#messages').append($('<br>'));
                reference.sentMessageUsername = null;
            }
        });

        service.socket.on('updateSocketList', function(list){
          reference.clientsNameList = list;
        });

        service.socket.on('addUserToSocketList', function(username){
            reference.exitedUser = false;
            reference.newUser = true;
            reference.newUserName = username;
        });

        service.socket.on('removeUserFromSocketList', function(username){
            reference.newUser = false;
            reference.exitedUser = true;
            reference.exitedUserName = username;
        });
    }


    sendMessage(data) {
        this.resFlag = true;
        let reference = this;
        service.socket.emit('chatMessageToSocketServer', data.value, function(respMsg, username){
            reference.sentMessageUsername = username;
            reference.response = respMsg;
        });
        $('#message-boxID').val(' ');
    }

    sendMessageOnEnter($event, messagebox) {
        if ($event.which === 13) { // ENTER_KEY
            this.sendMessage(messagebox);
        }
    }

    update() {
        this.resFlag = false;
        this.newUser = false;
        this.exitedUser = false;
    }

}
