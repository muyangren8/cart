import { CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SignViewPage } from './sign-view.page';

describe('SignViewPage', () => {
  let component: SignViewPage;
  let fixture: ComponentFixture<SignViewPage>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SignViewPage ],
      schemas: [CUSTOM_ELEMENTS_SCHEMA],
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SignViewPage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
