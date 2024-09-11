const btnAdd = document.querySelector('.btn-add-todo input');
const todoContainer = document.querySelector('.todo-container');

btnAdd.addEventListener("click", () => {
    const todo = prompt('할 일 입력하세요😎');

    if(todo) {  //확인 누른 경우
        //div 태그
        const todoDiv = document.createElement('div');
        todoDiv.classList.add('todo-item');

        //div 태그 안에 들어갈 체크박스, 버튼
        // const checkbox = document.createElement('input[type="checkbox"]');
        const checkbox = document.createElement('input');
        checkbox.type = 'checkbox';

        // 체크박스 선택.해제 시 색상 변경
        checkbox.addEventListener("click", () => {
            if(checkbox.checked) {
                todoDiv.style.backgroundColor = 'yellowgreen';
            } else {
                todoDiv.style.backgroundColor = 'white';
            }
        })
        
        const todoContent = document.createElement('span');
        todoContent.innerText = todo;

        const btnDelete = document.createElement('button');
        // 😎textContent 프로퍼티 검색함
        btnDelete.textContent = '삭제';

        // 삭제 버튼 이벤트
        btnDelete.addEventListener("click", () => {
            const isDelete = confirm('할 일을 삭제할까요?😥');
            if(isDelete) {
                todoContainer.removeChild(todoDiv);
            }
        });

        
        //div 태그 안에 요소들 추가하기
        todoDiv.appendChild(checkbox);
        todoDiv.appendChild(todoContent);
        todoDiv.appendChild(btnDelete);

        //todo 컨테이너에 div태그 추가하기
        todoContainer.appendChild(todoDiv);
        
    }
});

